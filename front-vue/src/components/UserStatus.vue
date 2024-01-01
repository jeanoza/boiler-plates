<template>
  <div class="wrapper">
    <div v-if="user" class="flex gap-2 center">
      <span>{{ user.name }}({{ user.email }})</span>
      <ButtonComponent label="logout" @click="handleOnClickLogout" class="capitalize" />
    </div>
    <ButtonComponent v-else label="login" @click="handleOnClickLogin" class="capitalize" />
  </div>
</template>
<script setup lang="ts">
import { onMounted, ref } from 'vue'
import ButtonComponent from '@/components/ButtonComponent.vue'
import router from '@/router'

interface User {
  name: string
  email: string
}

const user = ref<User>()

//TODO: fix this after implement auth
onMounted(() => {
  const userStr = localStorage.getItem('user')
  if (userStr) {
    user.value = JSON.parse(userStr)
  }
})

const handleOnClickLogout = () => {
  localStorage.removeItem('user')
  user.value = undefined
}

const handleOnClickLogin = () => {
  router.push('/auth')
}
</script>
<style scoped>
.wrapper {
  @apply flex justify-end items-center gap-2 w-80;
}
</style>
