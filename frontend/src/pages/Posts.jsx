import PostCheckpointCard from "../post_components/PostCheckpointCard.jsx";
import NewPost from "../post_components/NewPost.jsx";
import PostHistory from "../post_components/PostHistory.jsx";
import React, {useContext} from 'react';
import {CardContext} from "../context/CheckpointContext.jsx";
import postHistory from "../data/postHistory.js";
import NavbarOther from "../navbar_components/NavbarOther.jsx";

const Posts = () => {

    const context = useContext(CardContext)
    if (!context) {
        throw Error("This doesn't work!")
    }

    const {card} = context

    console.log(postHistory)
    console.log(postHistory.filter((post) => post.id === card.id))
    console.log(card)

    return (
        <div>
            <NavbarOther/>

            {/* Background Container*/}
            <div className="flex flex-col items-center justify-center bg-black">

                {/* Container for PostCheckpointCard, NewPost, and PostHistory */}
                <div className="flex flex-col items-center justify-center w-8/12 h-auto my-11 space-y-8 bg-black">

                    {/* PostCheckpointCard */}
                    <PostCheckpointCard key={card.id} {...card}/>

                    {/*    New Post */}
                    <NewPost/>

                    {/*    Post History */}
                    <div className="flex items-center justify-center">
                        <h1 className="text-3xl">Post History</h1>
                    </div>

                    {postHistory.filter(post => post.checkpointId === card.id).map(post => <PostHistory key={post.id} {...post}/>)
                    }
                </div>

            </div>
        </div>

    )
}

export default Posts;