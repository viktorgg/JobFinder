<template>
  <div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group
        id="Tittle-group"
        label="Title:"
        label-for="Tittle"
        description="Write title here"
      >
        <b-form-input
          id="Tittle"
          type="Tittle"
          v-model="form.name"
          placeholder="Enter tittle"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="company-group" label="Your Company Name:" label-for="company">
        <b-form-input
          id="company"
          v-model="form.name"
          placeholder="Enter company name"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="decsription-group" label="Description:" label-for="descriptiom">
        <b-form-select
          id="description"
          v-model="form.name"
          placeholder="Enter description"
          required
        ></b-form-select>
      </b-form-group>

      <b-button type="submit" variant="primary">Submit your ad</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>

  </div>
</template>

<script>
import axios from 'axios'

const API_URL = 'http://localhost:8081/ad/'

export default {
  name: 'AddAd',
    data() {
      return {
        form: {
          id: '',
          tittle: '',
          company_name: '',
          description: ''
        },
      }
    },
  methods: {
    onSubmit (event) {
      event.preventDefault()
      axios.post(API_URL + 'save', this.form)
    },
    onReset (event) {
      event.preventDefault()
      // Reset our form values
      this.form.tittle = ''
      this.form.company_name = ''
      this.form.description = null
      // Trick to reset/clear native browser form validation state
      this.show = false
      this.$nextTick(() => {
        this.show = true
      })
    }
  }
}
</script>

<style scoped>
</style>
