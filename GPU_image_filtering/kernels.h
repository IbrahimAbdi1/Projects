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

#ifndef __KERNELS__H
#define __KERNELS__H

/* TODO: you may want to change the signature of some or all of those functions,
 * depending on your strategy to compute min/max elements.
 * Be careful: "min" and "max" are names of CUDA library functions
 * unfortunately, so don't use those for variable names.*/

typedef struct common_work_t
{
    const int8_t *f;
    int32_t dimension;
            const int32_t *original_image;
            int32_t *output_image;
            int32_t width;
            int32_t height;
            int32_t max_threads;
            pthread_barrier_t barrier;
            int32_t work_chunk;
            int32_t minp;
            int32_t maxp;
            pthread_mutex_t lock;
} common_work;
typedef struct work_t
{
    common_work *common;
    int32_t id;
} work;

__device__ inline int apply2DGPU(const int8_t *f, int32_t dimension, const int32_t *original,int32_t width, int32_t height,int row, int column){
    int32_t sum = 0;
    int filter_centre = dimension / 2;

    int s_row = row - filter_centre;
    int s_column = column - filter_centre;
    for (int r = 0; r < dimension; r++)
    {
      int n_row = s_row + r;
      for (int c = 0; c < dimension; c++)
      {
        int n_column = s_column + c;
        if ((n_row >= 0) && (n_column >= 0) && (n_column < width) && (n_row < height))
        {
          sum += (f[r * dimension + c]) * (original[n_row * width + n_column]);
        }
      }
    }
    return sum;
}

template <unsigned int blockSize> __global__ void find_min_max(int32_t *max, int32_t *min,int pixelCount);
template <unsigned int blockSize> __global__ void find_min_max_f(int32_t *indata,int32_t *max, int32_t *min,int pixelCount);
void gpu_min_max_switch_threads(int pixelCount, int numThreads, int numBlocks, int32_t *indata, int32_t *max, int32_t *min, int first);
bool calculate_blocks_and_threads(int n, int &blocks, int &threads);



void run_best_cpu(const int8_t *filter, int32_t dimension, const int32_t *input,
                  int32_t *output, int32_t width, int32_t height);

void run_kernel1(const int8_t *filter, int32_t dimension, const int32_t *input,int32_t *output, int32_t width, int32_t height,int32_t *g_min_max);
__global__ void kernel1(const int8_t *filter, int32_t dimension,
                        const int32_t *input, int32_t *output, int32_t width,
                        int32_t height);
__global__ void normalize1(int32_t *image, int32_t width, int32_t height,
                           int32_t *smallest, int32_t *biggest);

void run_kernel2(const int8_t *filter, int32_t dimension, const int32_t *input,
                 int32_t *output, int32_t width, int32_t height, int32_t*g_min_max);
__global__ void kernel2(const int8_t *filter, int32_t dimension,
                        const int32_t *input, int32_t *output, int32_t width,
                        int32_t height);
__global__ void normalize2(int32_t *image, int32_t width, int32_t height, int32_t *smallest, int32_t *biggest);

void run_kernel3(const int8_t *filter, int32_t dimension, const int32_t *input,
                 int32_t *output, int32_t width, int32_t height,int32_t *g_min_max);
__global__ void kernel3(const int8_t *filter, int32_t dimension,
                        const int32_t *input, int32_t *output, int32_t width,
                        int32_t height);
__global__ void normalize3(int32_t *image, int32_t width, int32_t height, int32_t *smallest, int32_t *biggest);

void run_kernel4(const int8_t *filter, int32_t dimension, const int32_t *input,
                 int32_t *output, int32_t width, int32_t height,int32_t *g_min_max);
__global__ void kernel4(const int8_t *filter, int32_t dimension,
                        const int32_t *input, int32_t *output, int32_t width,
                        int32_t height);
__global__ void normalize4(int32_t *image, int32_t width, int32_t height, int32_t *smallest, int32_t *biggest);

void run_kernel5(const int8_t *filter, int32_t dimension, const int32_t *input,
                 int32_t *output, int32_t width, int32_t height,int32_t *g_min_max);
/* This is your own kernel, you should decide which parameters to add
   here*/
__global__ void kernel5(int32_t dimension,
                        const int32_t *input, int32_t *output, int32_t width,
                        int32_t height);
__global__ void normalize5(int32_t *image, int32_t width, int32_t height, int32_t *smallest, int32_t *biggest);


#endif