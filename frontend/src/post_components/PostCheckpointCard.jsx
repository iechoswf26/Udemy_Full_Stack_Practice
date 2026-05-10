

const PostCheckpointCard = (slide) => {
    return (
    //     Card
    <div key={slide.id} className="bg-[#8C978C] p-2 mx-6 mb-10 rounded-2xl">

        {/*    Flex container inside card*/}
        <div className="flex flex-col rounded-l-xl">

            {/*    Image*/}
            <img
                src={slide.image}
                alt={slide.title}
                className="object-fit inset-x-0 top-0 h-60 rounded-l-xl rounded-r-xl"
            />

            {/* Content*/}
            <div className="p-6">
                <h2 className="text-3xl font-bold text-center text-[#2A2D2A]">{slide.title}</h2>
                <p className="max-w-lg my-1 text-xl font-medium leading-5 tracking-wide text-justify text-[#2A2D2A]">{slide.description}</p>
                <p className="max-w-lg my-2 mt-6 text-s leading-5 tracking-wide text-lg text-justify text-[#E7E3DA]">{slide.question}</p>

            </div>

        </div>

    </div>


    )
}

export default PostCheckpointCard;