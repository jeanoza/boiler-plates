<template>
  <form class="form" @submit.prevent="handleOnSubmit">
    <div class="row-wrapper">
      <InputField label="name" type="text" v-model="loginFormData.name" v-if="!isSignIn" />
      <InputField label="email" type="email" v-model="loginFormData.email" />
      <InputField label="password" type="password" v-model="loginFormData.password" />
    </div>
    <div class="row-wrapper toggle">
      <span v-if="!isSignIn">Do you have already account?</span>
      <span v-if="isSignIn">Do you want to join us?</span>
      <span class="click" @click="handleOnToggle">Click</span>
    </div>
    <div class="row-wrapper btn-container">
      <ButtonComponent :label="isSignIn ? 'LogIn' : 'Join'" />
      <ButtonComponent label="Cancel" @click.prevent="clear" />
    </div>
  </form>
</template>

<script setup lang="ts">
import { reactive, defineAsyncComponent, ref } from 'vue'

const InputField = defineAsyncComponent(() => import('@/components/InputField.vue'))
const ButtonComponent = defineAsyncComponent(() => import('@/components/ButtonComponent.vue'))

const loginFormData = reactive({
  name: '',
  email: '',
  password: ''
})
const isSignIn = ref(true)

const handleOnSubmit = (e: Event) => {
  e.preventDefault()
  //get password and email then send logic
  console.log(loginFormData)
  clear()
}
const handleOnToggle = () => {
  isSignIn.value = !isSignIn.value
}

const clear = () => {
  loginFormData.name = ''
  loginFormData.email = ''
  loginFormData.password = ''
}
</script>

<style scoped>
form {
  @apply max-w-md w-full m-auto;
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
