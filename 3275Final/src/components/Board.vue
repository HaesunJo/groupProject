<template>
    <div>
        <b-table striped hover :items="items" :per-page="perPage" :current-page="currentPage" :fields="fields" @row-click="rowClick"></b-table>
        <b-pagination
            v-model="currentPage"
            :total-row="rows"
            :per-page="perPage"
            align="center"
            ></b-pagination>
        <b-button @click="writeContent">Write</b-button>
    </div>
</template>

<script>
import data from '@/data';

export default {
    data(){

    let items = data.Content.sort((a, b) => {return b.content_id - a.content_id});
    items = items.map(contentItem => {return {...contentItem, user_name: data.User.filter(userItem => userItem.user_id === contentItem.user_id)[0].name}})

        return{
            currentPage: 1,
            perPage: 10,
            fields: [
                {
                    key: 'content_id',
                    labe: 'No.'
                }, 
                {
                    key: 'title',
                    labe: 'Title'
                },
                {
                    key: 'created_at',
                    labe: 'Date'
                },
                {
                    key: 'user_name',
                    labe: 'Writer'
                }
            ],
            itmes: items
        };
    },
    methods:{
        rowClick(item, index, e){
            this.$router.push({
                path: `/board/detail/${item.content_id}`
            })
        },
        writeContent(){
            this.$router.push({
                path: '/board/create'
            })
        }

    },
    computed: {
        rows(){
            return this.items.length
        }
    }
};
</script>