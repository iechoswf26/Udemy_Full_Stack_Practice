import FormCheckpointCard from "../Form_Components/FormCheckpointCard.jsx";
import NewPost from "../Form_Components/NewPost.jsx";
import PostHistory from "../Form_Components/PostHistory.jsx";
import {slides} from '../data/chapterOne.js'

const Form = () => {


    return (

        // Background Container
        <div className="flex flex-col items-center h-auto justify-center bg-[#3B443B]">

            <h1 className="text-white text-3xl font-bold py-7">Form Page</h1>

            {/* Form */}
            <div className="flex flex-col items-center w-3/4 h-auto mt-1 pt-6 bg-[#D4CFC4] rounded-lg shadow-lg">


                {/* FormCheckpointCard */}
                {slides.map((slide) => {
                    return (
                        <FormCheckpointCard key={slide.id} {...slide}/>
                    )
                })}


                {/*    New Post */}
                <NewPost/>


                {/*    Post History */}
                <div className="flex items-center justify-center">
                    <h1 className="text-3xl">Post History</h1>
                </div>
                <PostHistory/>

            </div>

        </div>
    )
}

export default Form;