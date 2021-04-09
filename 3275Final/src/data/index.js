export default {
    User: [{
            user_id: 1,
            name: customer1,
            created_at: '2021-04-03'
        },
        {
            user_id: 2,
            name: customer2,
            created_at: '2021-05-03'
        },
        {
            user_id: 3,
            name: customer3,
            created_at: '2021-06-03'
        }
    ],
    Content: [{
            content_id: 1,
            user_id: 1,
            title: 'I like the classes here',
            context: 'Yoga class was amazing',
            created_at: '2021-04-03',
            updated_at: null

        },
        {
            content_id: 2,
            user_id: 3,
            title: 'can I ask something?',
            context: 'are you open on holidays?',
            created_at: '2021-05-03',
            updated_at: null

        },
        {
            content_id: 3,
            user_id: 2,
            title: 'How much is 6 weeks meal plan?',
            context: 'how much?',
            created_at: '2021-04-03',
            updated_at: null

        }
    ]
}