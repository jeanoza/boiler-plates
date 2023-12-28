<script setup lang="ts">
const date = new Date()

const year = date.getFullYear()
</script>
<template>
  <footer class="h-12">
    <div
      class="flex justify-center items-center h-full text-neutral-300 border-t border-neutral-200"
    >
      <span>All right reserved by Jeanoza</span>
      <span>© {{ year }}</span>
    </div>
  </footer>
</template>
