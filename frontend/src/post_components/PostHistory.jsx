import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faRectangleXmark} from '@fortawesome/free-solid-svg-icons'

const PostHistory = ({id, checkpointId, username, post, date, time}) => {
    return (
        <div className="flex flex-col w-11/12 h-65 my-2 p-3 mb-8 border-2 rounded-xl border-[#A8ADA3] bg-[#8C978C]">

            {/*    Text Area and Button*/}
            <div className="mt-3 space-y-3 px-4 ">

                <div className="flex justify-between">
                    <p className="text-xl">{username}</p>
                </div>

                <p className="p-2 px-4 h-25 border border-[#7C857C] rounded-xl bg-[#6E7C7A] text-start text-[#E7E3DA] text-lg placeholder:text-[#D4CFC4] focus:outline-none">{post}</p>

                <div className="flex justify-between">
                    <p className="text-[#2F3E2F] text-lg font-medium">{date}/{time}</p>
                    <button className="px-5 py-3 rounded-md bg-[#2F3E2F] text-[#E7E3DA] hover:bg-[#161d16] transition">Delete</button>
                </div>

            </div>

        </div>

    )
}

export default PostHistory;