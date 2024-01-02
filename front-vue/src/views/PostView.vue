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
  created_by: string
  created_at: string
  updated_at: string
}

// const posts: Post[] = [
//   {
//     name: 'Etre et Néant',
//     content: "L'existence précède l'essence.",
//     created_by: 'Jean-Paul Sartre',
//     created_at: '2021-01-01',
//     updated_at: '2021-01-01'
//   },
//   {
//     name: 'Le Deuxième Sexe',
//     content: 'Femme ne nait pas, elle le devient.',
//     created_by: 'Simon de Beauvoir',
//     created_at: '2021-01-01',
//     updated_at: '2021-01-01'
//   }
// ]
const MainLayout = defineAsyncComponent(() => import('@/components/layouts/MainLayout.vue'))
const posts: Post[] = reactive([])

onMounted(() => {
  fetchData('get', 'posts').then((res) => {
    console.log(res)
    posts.push(...res)
  })
})
</script>
