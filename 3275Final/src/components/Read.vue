<!-- added by Haesun-->
<template>
	<div>
		<table class="table table-striped">
			<caption>Customer reviews</caption>
			<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Writer</th>
				<th scope="col">Title</th>
				<th scope="col">Content</th>
			</tr>
			</thead>

			<tbody>
				<tr :key = "index" v-for="(value, index) in data" @click="detail(index)">
					<td>{{index}}</td>
					<td>{{data.writer}}</td>
					<td>{{data.title}}</td>
					<td>{{data.content}}</td>
				</tr>
			</tbody>
		</table>

		<button @click = "write">Write</button>
	</div>
</template>

<script>
import data from '@/data';

export default {
	name: 'Read',
	data(){
		return{
			data: data
		}
	},
	methods: {
		write() {
			this.$router.push({
				path: 'create'
			})
        },
        detail(index){
            this.$router.push({
                name: 'Detail',
                params:{
                    contentId: index
                }
            })
        }
	}
}
</script>

