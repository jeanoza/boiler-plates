<script setup lang="ts">
import MainLayout from '@/components/layouts/MainLayout.vue'
import ButtonComponent from '@/components/ButtonComponent.vue'
</script>

<template>
  <MainLayout>
    <ButtonComponent :label="'test button'" />
  </MainLayout>
</template>
