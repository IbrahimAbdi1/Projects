/* ------------
 * This code is provided solely for the personal and private use of
 * students taking the CSC367H5 course at the University of Toronto.
 * Copying for purposes other than this use is expressly prohibited.
 * All forms of distribution of this code, whether as given or with
 * any changes, are expressly prohibited.
 *
 * Authors: Bogdan Simion, Felipe de Azevedo Piovezan
 *
 * All of the files in this directory and all subdirectories are:
 * Copyright (c) 2019 Bogdan Simion
 * -------------
 */

#include "kernels.h"
#include <stdio.h>
#include <string>
#include <unistd.h>
#include <math.h>

void run_kernel2(const int8_t *filter, int32_t dimension, const int32_t *input, int32_t *output, int32_t width, int32_t height, int32_t *g_min_max)
{
  // Figure out how to split the work into threads and call the kernel below.
  int pixelCount = width * height;
  int numBlocks = pixelCount / 1024;
  int first = 1;
  int numThreads, nblocks;
  int iteration_n = pixelCount;

  kernel2<<<numBlocks + 1, 1024>>>(filter, dimension, input, output, width, height);

  int32_t *max = g_min_max;
  int32_t *min = g_min_max + (numBlocks + 1);
  bool should_repeat = calculate_blocks_and_threads(iteration_n, nblocks, numThreads);
  gpu_min_max_switch_threads(iteration_n, numThreads, nblocks, output, max, min, first);

  first = 0;

  while (should_repeat)
  {
    iteration_n = nblocks;
    should_repeat = calculate_blocks_and_threads(iteration_n, nblocks, numThreads);
    gpu_min_max_switch_threads(iteration_n, numThreads, nblocks, g_min_max, max, min, first);
  }

  normalize2<<<numBlocks + 1, 1024>>>(output, width, height, min, max);
}

__global__ void kernel2(const int8_t *filter, int32_t dimension, const int32_t *input, int32_t *output, int32_t width, int32_t height)
{
  // get index given tid
  int idx = blockIdx.x * blockDim.x + threadIdx.x;

  if (idx < height * width)
  {
    int row = idx / width;
    int column = idx % width; // expensive

    output[idx] = apply2DGPU(filter,dimension,input,width,height,row, column);
  }
}

__global__ void normalize2(int32_t *image, int32_t width, int32_t height, int32_t *smallest, int32_t *biggest)
{
  int idx = blockIdx.x * blockDim.x + threadIdx.x;

  if (idx < height * width)
  {
    if (smallest[0] != biggest[0])
    {
      image[idx] = ((image[idx] - smallest[0]) * 255) / (biggest[0] - smallest[0]);
    }
  }
}
