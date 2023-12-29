<template>
  <MainLayout class="about">
    <h1>Blog</h1>
  </MainLayout>
</template>

<script setup lang="ts">
import { defineAsyncComponent } from 'vue'

const MainLayout = defineAsyncComponent(() => import('@/components/layouts/MainLayout.vue'))
</script>
