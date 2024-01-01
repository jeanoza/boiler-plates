<template>
  <header class="header">
    <RouterLink to="/" class="w-80">
      <img alt="Vue logo" class="h-8 w-auto" src="@/assets/logo.svg" />
    </RouterLink>
    <nav>
      <RouterLink class="nav-item" v-for="nav in navList" :key="nav.name" :to="nav.path">
        {{ nav.name }}
      </RouterLink>
    </nav>
    <UserStatus />
  </header>
</template>

<script setup lang="ts">
import { defineAsyncComponent } from 'vue'
import { RouterLink } from 'vue-router'

const UserStatus = defineAsyncComponent(() => import('@/components/UserStatus.vue'))

const navList = [
  {
    name: 'Home',
    path: '/'
  },
  {
    name: 'Post',
    path: '/post'
  }
]
</script>

<style scoped>
.header {
  @apply flex justify-between items-center h-12 px-4 border-b border-neutral-200;
}
.nav-item {
  @apply p-2 hover:text-neutral-600 dark:hover:text-neutral-300;
}
</style>
