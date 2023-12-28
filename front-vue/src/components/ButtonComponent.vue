<script setup lang="ts">
const { label } = defineProps({ label: String })
</script>
<template>
  <button class="p-2 bg-neutral-800 rounded text-white">
    {{ label }}
  </button>
</template>
