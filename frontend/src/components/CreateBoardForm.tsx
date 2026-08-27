import { useState } from 'react'

type CreateBoardFormProps = {
    onCreate: (title: string, options: string[]) => void
}

function CreateBoardForm({ onCreate }: CreateBoardFormProps) {
    const [title, setTitle] = useState('')
    const [options, setOptions] = useState(['', ''])
    const [error, setError] = useState('')

    function handleSubmit(event: React.FormEvent<HTMLFormElement>) {
        event.preventDefault()

        if (title.trim() === '') {
            setError('Question cannot be empty.')
            return
        }

        if (options.length < 2) {
            setError('You need at least two options.')
            return
        }

        if (options.some((option) => option.trim() === '')) {
            setError('All options must have a value.')
            return
        }

        setError('')
        onCreate(
            title.trim(),
            options.map((option) => option.trim()),
            )
    }

    return (
        <form onSubmit={handleSubmit}>
            <label htmlFor="title">Question</label>

            <input
                id="title"
                type="text"
                value={title}
                onChange={(event) => setTitle(event.target.value)}
                placeholder="What should we build next?"
            />

            {options.map((option, index) => (
                <div key={index}>
                    <label htmlFor={`option-${index}`}>
                        Option {index + 1}
                    </label>

                    <input
                        id={`option-${index}`}
                        type="text"
                        value={option}
                        onChange={(event) => {
                            const newOptions = [...options]
                            newOptions[index] = event.target.value
                            setOptions(newOptions)
                        }}
                    />

                    <button
                        type="button"
                        onClick={() => {
                            const newOptions = options.filter(
                                (_, optionIndex) => optionIndex !== index,
                            )

                            setOptions(newOptions)
                        }}
                        disabled={options.length <= 2}
                    >
                        Remove
                    </button>
                </div>
            ))}

            <button
                type="button"
                onClick={() => setOptions([...options, ''])}
            >
                Add option
            </button>

            {error && <p>{error}</p>}

            <button type="submit">
                Create board
            </button>
        </form>
    )
}

export default CreateBoardForm