import './App.css'
import CreateBoardForm from './components/CreateBoardForm'

function App() {
    function handleBoardCreate(title: string, options: string[]) {
        console.log('Board received in App:')
        console.log('Title:', title)
        console.log('Options:', options)
    }

    return (
        <main>
            <h1>Create a Decision Board</h1>

            <CreateBoardForm onCreate={handleBoardCreate} />
        </main>
    )
}

export default App