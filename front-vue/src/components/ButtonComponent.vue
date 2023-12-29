<template>
  <button>{{ label }}</button>
</template>

<script setup lang="ts">
const { label } = defineProps({ label: String })
</script>

<style scoped>
button {
  @apply flex p-2 bg-neutral-800 rounded text-white;
}
</style>
