<template>
  <footer class="footer">
    <span>All right reserved by Jeanoza</span>
    <span>© {{ year }}</span>
  </footer>
</template>

<script setup lang="ts">
const date = new Date()
const year = date.getFullYear()
</script>

<style scoped>
.footer {
  @apply h-12 flex justify-center items-center border-t border-neutral-200;
}
</style>
