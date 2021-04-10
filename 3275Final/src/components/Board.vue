<template>
	<div>
		<b-table striped hover
				:items="items"
				:fields="fields"
				@row-clicked="rowClick">
		</b-table>
		<!-- <b-table striped hover :items="items" :per-page="perPage" :current-page="currentPage" :fields="fields" @row-clicked="rowClick"></b-table> -->
		<!-- <b-pagination
			v-model="currentPage"
			:total-row="rows"
			:per-page="perPage"
			align="center"
			></b-pagination> -->
		<b-button @click="writeContent">Write</b-button>
	</div>
</template>

<script>
	import data from '@/data';

	// created

	export default {
		name: 'Board',
		data () {
			//updated

			// array function : javascript
			let items = data.Content.sort((a, b) => {
				return b.content_id - a.content_id
			});
			items = items.map(contentItem => {
				return {
					...contentItem,
					user_name: data.User.filter(userItem => userItem.user_id === contentItem.user_id)[0].name
				}
			});
			
			return {
				fields: [
					{
						key: 'content_id',
						label: 'No.'
					}, 
					{
						key: 'title',
						label: 'Title'
					},
					{
						key: 'created_at',
						label: 'Date'
					},
					{
						key: 'user_name',
						label: 'Writer'
					}
				],
				items
			};
		},
		methods: {
			rowClick (item) {
				this.$router.push({
					name: "Detail",
					// path: `/board/detail/${item.content_id}`,
					params: { contentId: item.content_id, content: item }
				});
			},
			writeContent () {
				this.$router.push({
					path: `/board/create`
				})
			}
		}
	};
</script>