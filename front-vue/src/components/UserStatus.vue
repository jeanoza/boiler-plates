<template>
  <div v-if="user">user</div>
  <ButtonComponent v-else label="login" @click="handleOnClick" class="capitalize" />
</template>
<script setup lang="ts">
import { ref } from 'vue'
import ButtonComponent from '@/components/ButtonComponent.vue'
import router from '@/router'

const user = ref(null)

const handleOnClick = () => {
  router.push('/auth')
}
</script>
<style scoped></style>
