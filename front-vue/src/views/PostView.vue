<template>
  <MainLayout class="post">
    <div class="w-1/2 max-w-4xl m-auto">
      <div class="flex justify-end py-4">
        <ButtonComponent label="New" @click="$router.push('/post/create')" />
      </div>
      <TableComponent
        v-if="posts.length > 0"
        :data="posts"
        :headers="['id', 'name', 'content', 'createdAt', 'updatedAt', 'createdBy']"
      />
    </div>
  </MainLayout>
</template>

<script setup lang="ts">
import ButtonComponent from '@/components/ButtonComponent.vue'
import TableComponent from '@/components/TableComponent.vue'
import { fetchData } from '@/utils/api'
import { defineAsyncComponent, onMounted, reactive } from 'vue'

interface Post extends Record<string, unknown> {
  name: string
  content: string
  member: {
    id: number
    name: string
    email: string
  }
  createdAt: string
  updatedAt: string
}

const MainLayout = defineAsyncComponent(() => import('@/components/layouts/MainLayout.vue'))
const posts: Post[] = reactive([])

onMounted(() => {
  fetchData('get', 'posts').then((res) => {
    res.forEach((post: Post) => {
      post.createdBy = post.member.name
    })
    posts.push(...res)
  })
})
</script>
