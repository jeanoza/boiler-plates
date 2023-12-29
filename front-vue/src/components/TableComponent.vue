<template>
  <table class="table">
    <thead>
      <tr>
        <th v-for="header in headers" :key="header">{{ header }}</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(post, index) in data" :key="index">
        <td v-for="header in headers" :key="header" class="p-2">
          {{ post[header] }}
        </td>
      </tr>
    </tbody>
  </table>
</template>
<script setup lang="ts" generic="T extends Record<string, unknown>">
const { headers, data } = defineProps<{
  headers: string[]
  data: T[]
}>()
</script>
<style scoped>
/* TODO: styling:)) */
.table {
  @apply w-full table-fixed;
}
</style>
