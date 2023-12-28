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

<template>
  <header class="flex justify-between items-center h-12 px-4 border-b border-neutral-200">
    <RouterLink to="/">
      <img alt="Vue logo" class="h-8 w-auto" src="@/assets/logo.svg" />
    </RouterLink>
    <nav>
      <RouterLink class="p-2" v-for="nav in navList" :key="nav.name" :to="nav.path">
        {{ nav.name }}
      </RouterLink>
    </nav>
  </header>
</template>
