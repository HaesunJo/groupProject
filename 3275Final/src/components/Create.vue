<!-- added by Haesun-->
<template>
    <div>
        <b-input v-model="subject" placeholder="writer" />
        <!-- <b-input v-model="title" placeholder="title" />
        <b-input v-model="content" placeholder="content" /> -->
        <b-form-textarea
            v-model="context"
            placeholder="Type here"
            rows="3"
            max-rows="6"
        ></b-form-textarea>
        <b-button @click="updateMode ? updateContent() : uploadContent">Save</b-button>
        <b-button @click="cancel">Cancel</b-button>

        <!-- <button @click="index !== undefined ? update() : write()">{{index !== undefined ? 'Edit' : 'Upload'}}</button> -->
    </div>
</template>
<script>
import data from '@/data';

export default {
    // name: 'Create',
    // data(){
    //     const index = this.$route.prams.contentId;
    //     return{
    //         data: data,
    //         index: index,
    //         writer: index !== indefined ? data[index].writer: "",
    //         title: index !== indefined ? data[index].title: "",
    //         content: index !== indefined ? data[index].content: ""
    //     }
    // },
    
        name: 'Create',
        data(){
            return{
                subject:'',
                context:'',
                userId: 1,
                createdAt: '2021-04-03',
                updatedAt: null,
                updateObject: null,
                updateMode: this.$route.prams.contentId > 0 ? true : false
            }
        },
        created(){
            if(this.$route.prams.contentId > 0){
                const contentId = Number(this.$route.params.contentId);
                this.updateObject = data.Content.filter(item => item.content_id === contentId)[0];
                this.subject = this.updateObject.title;
                this.context = this.updateObject.context;
            }
        },
        methods: {
            uploadContent(){
                let items = data.Content.sort((a,b) => {return b.content_id - a.content_id});
                const content_id = items[0].content_id + 1;

                data.Content.push({
                    content_id: content_id,
                    user_id: this.userId,
                    title: this.subject,
                    context: this.context,
                    created_at: this.createdAt,
                    updated_at: null
                })
            },
            updateContent(){
                this.updateObject.title = this.subject;
                this.updateObject.context = this.context;
                this.$router.push({
                    path:'/board'
                })
            },
            cancel(){
                this.$router.push({
                    path: '/board'
                })
            }
        }
        // methods: {
        // write(){
        //     this.data.push({
        //         writer: this.writer,
        //         title: this.title,
        //         content: this.content
        //     })
        //     this.$router.push({
        //         path:'/'
        //     })
        // },
        // update(){
        //     data[this.index].writer = this.writer
        //     data[this.index].title = this.title
        //     data[this.index].content = this.writer

        // }
    // }
}
</script>