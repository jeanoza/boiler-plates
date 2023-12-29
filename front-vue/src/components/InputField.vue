<template>
  <div class="input-field">
    <label :class="`label ${isActive(modelValue) ? 'active' : ''}`">
      {{ label }}
    </label>
    <input
      :class="`input ${isActive(modelValue) ? 'active' : ''}`"
      v-bind="$attrs"
      :type="type"
      :value="modelValue"
      @input="$emit('update:modelValue', ($event.target as HTMLInputElement).value)"
    />
  </div>
</template>

<script setup lang="ts">
defineProps({
  label: String,
  type: String,
  modelValue: String
})
defineEmits(['update:modelValue'])

const isActive = (value?: String) => {
  return value && value.length > 0
}
</script>

<style scoped>
.input-field {
  @apply relative pt-3 pb-2 px-2 border rounded text-lg mb-4;
}
.label {
  @apply absolute capitalize top-2 left-2 text-lg;
}
label.active {
  @apply text-xs text-blue-400 top-1;
}
.input {
  @apply bg-inherit outline-none w-full;
}
input.active {
  @apply border-b;
}
</style>
