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
            <div className="flex flex-col items-center h-auto justify-center bg-[#3B443B]">

                <h1 className="text-white text-3xl font-bold py-7">Form Page</h1>

                {/* Posts */}
                <div className="flex flex-col items-center w-3/4 h-auto mt-1 pt-6 bg-[#D4CFC4] rounded-lg shadow-lg">


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