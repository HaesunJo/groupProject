<template>
    <div>
        <b-card>
        <!-- <div>{{data.writer}}</div>
        <div>{{data.title}}</div>
        <div>{{data.content}}</div> -->
        <div class="detail-content-info">
            <div class="detail-content-info-left">
                <div class="detail-content-info-left-number">
                    {{contentId}}
                </div>
                <div class="detail-content-info-left-subject">
                    {{title}}
                </div>
            </div>

            <div class="detail-content-info-right">
                <div class="detail-content-info-right-user">
                    Writer: {{user}}
                </div>
                <div class="detail-content-info-right-created">
                    Date: {{created}}
                </div>
            </div>
        </div>
        <div class="detail-content">
            {{context}}
        </div>

            <div class="detail-button">
                <b-button variant="primary" @click="updateData">Edit</b-button>
                <b-button variant="success" @click="deleteData">Delete</b-button>
            </div>

        </b-card>
    </div>
</template>

<script>
import data from '@/data';

export default {
    name: 'Detail',
    data(){
        const contentId = Number(this.$route.params.contentId);
        const contentData = data.Content.filter(item => item.content_id === contentId)[0]
        return{
            contentId: contentId,
            title: contentData.title,
            context: contentData.context,
            user: data.User.filter(item => item.user_id === contentData.user_id)[0].name,
            created: contentData.created_at
        };
    },
    methods: { 
        deleteData() {
            const content_index = data.Content.findIndex(item => item.content_id === this.contentId);
            data.splice(content_index, 1)
            this.$router.push({
                path: '/board'
            })
        },
        updateData(){
            this.$router.push({
                name: `/board/create${this.contentId}`,
                params:{
                    contentId: this.index
                }
            })
        }

    }
}
</script>

<style scoped>
.detail-content-info{
    border: 1px solid #2a2a2b;
    display: flex;
    justify-content: space-between;
}

.detail-content-info-left{
    width: 720px;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
    padding: 1rem;
}

.detail-content-info-right{
    width: 300px;
    display: flex;
    flex-direction: column;
    justify-content:center;
    align-items: center;
    padding: 1rem;
}

.detail-content {
    border: 1px solid #2a2a2b;
    display: flex;
    justify-content: space-between;
}
</style>