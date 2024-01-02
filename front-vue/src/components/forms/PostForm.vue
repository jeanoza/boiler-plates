<template>
  <form class="form" @submit.prevent="handleOnSubmit">
    <div class="row-wrapper">
      <InputField label="Title" type="text" v-model="postFormData.name" />
      <textarea
        v-model="postFormData.content"
        class="w-full bg-inherit border rounded min-h-80 p-2 text-lg mb-4"
      ></textarea>
    </div>
    <div class="row-wrapper btn-container">
      <ButtonComponent label="Create" />
      <ButtonComponent label="Cancel" @click.prevent="$router.push('/post')" />
    </div>
  </form>
</template>

<script setup lang="ts">
import { reactive, defineAsyncComponent, ref } from 'vue'
import { fetchData } from '@/utils/api'
import router from '@/router'

const InputField = defineAsyncComponent(() => import('@/components/InputField.vue'))
const ButtonComponent = defineAsyncComponent(() => import('@/components/ButtonComponent.vue'))

const postFormData = reactive({
  name: '',
  content: ''
})

const handleOnSubmit = (e: Event) => {
  e.preventDefault()
  const url = 'posts'

  fetchData('post', url, postFormData)
    .then((_) => {
      router.push('/post')
    })
    .catch((err) => {
      alert(err.message)
    })
}

const clear = () => {
  postFormData.name = ''
  postFormData.content = ''
}
</script>

<style scoped>
form {
  @apply max-w-md w-full;
}
.row-wrapper {
  @apply w-full m-auto;
}
.btn-container {
  @apply flex justify-end gap-2;
}
.click {
  @apply cursor-pointer text-blue-400;
}
</style>
