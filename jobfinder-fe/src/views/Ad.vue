<template>
<div>
<button v-on:click="searchAds">Search</button>
<b-table
  striped
  hover
  bordered
  :items="ads"
  :fields="fields"
>

  <template slot="top-row" slot-scope="{ fields }">
    <td v-for="field in fields" :key="field.id">
      <input v-model="filters[field.key]" :placeholder="field.label">
      <tr v-for="ad in totalItems" :key="ad.id">
        <td>{{ad.title}}</td>
        <td>{{ad.description}}</td>
        <td>{{ad.company_name}}</td>
      </tr>
    </td>
  </template>
</b-table>
</div>
</template>

<script>
import AdService from '../services/ad-service'

export default {
  name: 'Ad',
  data () {
    return {
      msg: '',
      totalItems: '',
      ads: [{
        id: '',
        title: '',
        description: '',
        company_name: ''
      }],
      fields: [
        { key: 'title', label: 'Position' },
        { key: 'description', label: 'Description' },
        { key: 'company_name', label: 'Employer' }
      ],
      filters: {
        title: '',
        description: '',
        company_name: ''
      }
    }
  },
  mounted () {
    AdService.getAllAds().then(
      response => {
        console.log(response)
        this.content = response
      },
      error => {
        this.content =
          (error.response && error.response.data) ||
          error.message ||
          error.toString()
      }
    )
  }
}
</script>

<style scoped>

</style>
