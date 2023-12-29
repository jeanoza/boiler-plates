<template>
  <MainLayout class="post">
    <div class="w-1/2 max-w-4xl m-auto">
      <div class="flex justify-end py-4">
        <ButtonComponent label="New" />
      </div>
      <TableComponent v-if="FAKE_DATA" :data="FAKE_DATA" :headers="Object.keys(FAKE_DATA[0])" />
    </div>
  </MainLayout>
</template>

<script setup lang="ts">
import ButtonComponent from '@/components/ButtonComponent.vue'
import TableComponent from '@/components/TableComponent.vue'
import { defineAsyncComponent } from 'vue'

interface Post extends Record<string, unknown> {
  name: string
  content: string
  created_by: string
  created_at: string
  updated_at: string
}
const FAKE_DATA: Post[] = [
  {
    name: 'Etre et Néant',
    content: "L'existence précède l'essence.",
    created_by: 'Jean-Paul Sartre',
    created_at: '2021-01-01',
    updated_at: '2021-01-01'
  },
  {
    name: 'Le Deuxième Sexe',
    content: 'Femme ne nait pas, elle le devient.',
    created_by: 'Simon de Beauvoir',
    created_at: '2021-01-01',
    updated_at: '2021-01-01'
  }
]
const MainLayout = defineAsyncComponent(() => import('@/components/layouts/MainLayout.vue'))
</script>
