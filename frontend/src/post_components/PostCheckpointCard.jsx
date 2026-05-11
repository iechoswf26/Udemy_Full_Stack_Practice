

const PostCheckpointCard = (slide) => {
    return (
    //     Card
    <div key={slide.id} className="flex flex-col items-center justify-center bg-gray-300 w-10/12 rounded-lg">

        <div className="flex flex-col items-center justify-center p-2">

            {/*    Image*/}
            <div>
                <img
                    src={slide.image}
                    alt={slide.title}
                    className="object-fit inset-x-0 top-0 rounded-lg"
                />
            </div>

            {/* Content*/}
            <div className="flex flex-col items-center justify-center space-y-6 my-6">
                <h2 className="font-heading font-bold text-4xl text-black">{slide.title}</h2>
                <p className="max-w-3xl font-body font-medium text-xl leading-6 tracking-normal text-justify text-black">{slide.description}</p>
                <p className="max-w-3xl font-body font-medium text-xl leading-6 tracking-normal text-justify text-black">{slide.question}</p>

            </div>

        </div>




    </div>


    )
}

export default PostCheckpointCard;