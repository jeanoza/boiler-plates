<template>
  <form class="form" @submit.prevent="handleOnSubmit">
    <div class="row-wrapper">
      <InputField label="email" type="email" v-model="loginFormData.email" />
      <InputField label="password" type="password" v-model="loginFormData.password" />
    </div>
    <div class="row-wrapper btn-container">
      <ButtonComponent label="Submit" />
      <ButtonComponent label="Cancel" @click.prevent="clear" />
    </div>
  </form>
</template>

<script setup lang="ts">
import { reactive, defineAsyncComponent } from 'vue'

const InputField = defineAsyncComponent(() => import('@/components/InputField.vue'))
const ButtonComponent = defineAsyncComponent(() => import('@/components/ButtonComponent.vue'))

const loginFormData = reactive({
  email: '',
  password: ''
})
const handleOnSubmit = (e: Event) => {
  e.preventDefault()
  //get password and email then send logic
  console.log(loginFormData)
  clear()
}
const clear = () => {
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
</style>
