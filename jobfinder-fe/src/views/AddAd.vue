<template>
  <div>
    <b-form @submit="onSubmit" @reset="onReset" >
      <b-form-group
        id="tittle-group"
        label="Title:"
        label-for="tittle"
      >
        <b-form-input
          id="tittle"
          type="Tittle"
          v-model="form.tittle"
          placeholder="Enter tittle"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="company-group" label="Your Company Name:" label-for="company">
        <b-form-input
          id="company"
          v-model="form.company_name"
          placeholder="Enter company name"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="decsription-group" label="Description:" label-for="descriptiom">
        <b-form-input
          id="description"
          v-model="form.description"
          placeholder="Enter description"
          required
        ></b-form-input>
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
  data () {
    return {
      form: {
        id: '',
        tittle: '',
        company_name: '',
        description: ''
      }
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
      this.form.description = ''
    }
  }
}
</script>

<style scoped>
</style>
