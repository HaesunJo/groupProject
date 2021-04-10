<template>
    <div>
        <b-card>
        <div class="detail-content-info">
            <div class="detail-content-info-left">
                <div class="detail-content-info-left-number">
                    {{content_id}}
                </div>
                <div class="detail-content-info-left-subject">
                    {{title}}
                </div>
            </div>

            <div class="detail-content-info-right">
                <div class="detail-content-info-right-user">
                    Writer: {{user_name}}
                </div>
                <div class="detail-content-info-right-created">
                    Date: {{created_at}}
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
import boardContent from '@/data/index';

let data = boardContent;

export default {
    name: 'Detail',
    data(){
        const content = this.$route.params.content;
        this.contentId = content.content_id;

        return{
            ...content
        };
    },
    methods: { 
        deleteData() {
            const content_index = data.Content.findIndex(row => row.content_id == this.contentId);
            data.Content.splice(content_index, 1)

            this.$router.push({ path: '/board' });
        },
        updateData(){
            // this.$router.push({
            //     name: `/board/create${this.contentId}`,
            //     params:{
            //         contentId: this.index
            //     }
            // })

            this.$router.push({ path: `/board/create/${this.contentId}` });
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