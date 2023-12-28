<script setup lang="ts">
import { RouterView } from 'vue-router'
import HeaderLayout from '@/components/layouts/HeaderLayout.vue'
import FooterLayout from './components/layouts/FooterLayout.vue'
</script>

<template>
  <HeaderLayout />
  <RouterView />
  <FooterLayout />
</template>

<style scoped></style>
