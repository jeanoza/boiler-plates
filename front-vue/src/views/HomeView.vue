<template>
  <MainLayout>
    <div class="flex flex-col w-screen h-full">
      <LoginForm />
    </div>
  </MainLayout>
</template>

<script setup lang="ts">
import MainLayout from '@/components/layouts/MainLayout.vue'
import LoginForm from '@/components/forms/LoginForm.vue'
</script>
