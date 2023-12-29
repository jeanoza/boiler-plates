<template>
  <header class="header">
    <RouterLink to="/">
      <img alt="Vue logo" class="h-8 w-auto" src="@/assets/logo.svg" />
    </RouterLink>
    <nav>
      <RouterLink class="nav-item" v-for="nav in navList" :key="nav.name" :to="nav.path">
        {{ nav.name }}
      </RouterLink>
    </nav>
  </header>
</template>

<script setup lang="ts">
import { RouterLink } from 'vue-router'

const navList = [
  {
    name: 'Home',
    path: '/'
  },
  {
    name: 'About',
    path: '/about'
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
