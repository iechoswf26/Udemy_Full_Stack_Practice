import PostCheckpointCard from "../post_components/PostCheckpointCard.jsx";
import NewPost from "../post_components/NewPost.jsx";
import PostHistory from "../post_components/PostHistory.jsx";
import React, {useContext} from 'react';
import {CardContext} from "../context/CheckpointContext.jsx";
import NavbarOther from "../navbar_components/NavbarOther.jsx";
import DeletePostModal from "../post_components/DeletePostModal.jsx";
import EditPostModal from "../post_components/EditPostModal.jsx";

const Posts = () => {

    const context = useContext(CardContext)
    if (!context) {
        throw Error("This doesn't work!")
    }

    const {card} = context


    return (
        <div>
            <NavbarOther/>

            {/*<EditPostModal/>*/}
            {/*<DeletePostModal/>*/}

            {/* Background Container*/}
            <div className="flex flex-col items-center justify-center bg-black">

                {/* Container for PostCheckpointCard, NewPost, and PostHistory */}
                <div className="flex flex-col items-center justify-center w-8/12 m-10 space-y-10 bg-black">

                    {/* PostCheckpointCard */}
                    <PostCheckpointCard key={card.id} {...card}/>

                    {/*    New Post */}
                    <NewPost/>

                    {/*    Post History */}
                    {card.posts && card.posts.map(post => <PostHistory key={post.id} {...post}/>)}
                </div>

            </div>
        </div>

    )
}

export default Posts;