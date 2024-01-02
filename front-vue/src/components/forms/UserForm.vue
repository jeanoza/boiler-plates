<template>
  <form class="form" @submit.prevent="handleOnSubmit">
    <div class="row-wrapper">
      <InputField label="name" type="text" v-model="loginFormData.name" v-if="isSignUp" />
      <InputField label="email" type="email" v-model="loginFormData.email" />
      <InputField label="password" type="password" v-model="loginFormData.password" />
    </div>
    <div class="row-wrapper toggle">
      <span v-if="isSignUp">Do you have already account?</span>
      <span v-else>Do you want to join us?</span>
      <span class="click" @click="handleOnToggle">Click</span>
    </div>
    <div class="row-wrapper btn-container">
      <ButtonComponent :label="isSignUp ? 'Join' : 'Login'" />
      <ButtonComponent label="Cancel" @click.prevent="clear" />
    </div>
  </form>
</template>

<script setup lang="ts">
import { reactive, defineAsyncComponent, ref } from 'vue'
import { fetchData } from '@/utils/api'
import router from '@/router'

const InputField = defineAsyncComponent(() => import('@/components/InputField.vue'))
const ButtonComponent = defineAsyncComponent(() => import('@/components/ButtonComponent.vue'))

const loginFormData = reactive({
  name: '',
  email: '',
  password: ''
})
const isSignUp = ref(false)

const handleOnSubmit = (e: Event) => {
  e.preventDefault()
  const url = isSignUp.value ? 'auth/sign-up' : 'auth/sign-in'

  fetchData('post', url, loginFormData)
    .then((_) => {
      window.location.href = '/'
      // TODO: Normally, I should use router.push('/');
      // But for this, I should force re-render UserStatus.vue for getting user data.
      // router.push('/')
    })
    .catch((err) => {
      alert(err.message)
    })
}
const handleOnToggle = () => {
  isSignUp.value = !isSignUp.value
}

const clear = () => {
  loginFormData.name = ''
  loginFormData.email = ''
  loginFormData.password = ''
}
</script>

<style scoped>
form {
  @apply max-w-md w-full;
}
.row-wrapper {
  @apply w-1/2 m-auto;
}
.btn-container {
  @apply flex justify-end gap-2;
}
.toggle {
  @apply flex justify-between mb-4;
}
.click {
  @apply cursor-pointer text-blue-400;
}
</style>
