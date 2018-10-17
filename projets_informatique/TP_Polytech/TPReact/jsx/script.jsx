// ===== Classes
class TaskList extends React.Component {
    constructor(props) {
        super(props)
        this.state = { tasks: this.props.tasks };
        this.addTask = this.addTask.bind(this);
    }

    addTask(taskTitle) {
        let newState = this.state
        newState.tasks.push(taskTitle)
        this.setState(newState)
    }

    render() {
        let tasks = this.state.tasks
        return (
            <div style={{backgroundColor: "#fa5", boxShadow: "0 1px 3px", display: "flex", flexDirection:"column", marginRight: "5px", padding: "10px"}}>
                <h2>{this.props.name}</h2>
                <ul>
                    {tasks.map((t, idx) => <Task key={idx} title={t} /> )}
                </ul>
                <TaskForm callbackAddTask={this.addTask}/>
            </div>
        )
    }
}

class TaskForm extends React.Component {
    constructor(props) {
        super(props)
        this.state = {nameNewUser: ""}
        this.updateNewTaskName = this.updateNewTaskName.bind(this);
        this.handleAdd = this.handleAdd.bind(this);
    }

    updateNewTaskName(event) {
        this.setState({nameNewUser: event.target.value});
    }

    handleAdd() {
        if(this.state.nameNewUser != "") {
            this.props.callbackAddTask(this.state.nameNewUser)
            this.setState({nameNewUser: ""})
        }
        else {
            alert("Entrez l'ID du nouvel utilisateur.")
        }
    }

    render() {
        return (
            <div class="form-group" style={{display:"flex", flex:1, flexDirection:"column", justifyContent:"flex-end", margin: 0}}>
                <label for="newUser">Ajouter un nouvel utilisateur: </label>
                <input class="form-control" name="newUser" value={this.state.nameNewUser} onChange={this.updateNewTaskName} required/>
                <button type="submit" style={{backgroundColor: "#33a", color: "#eee", marginTop: "10px"}} onClick={this.handleAdd}>Ajouter</button>
            </div>
        )
    }
}

const Task = (props) => {
    return <li>{props.title}</li>
}

// ===== Element creation and rendering
const container = document.getElementById('content')
const users1 = ['0123-4857-8143-5196', '8143-4857-0123-5196']
const users2 = ['6623-8657-6343-0153', '0153-4857-8143-5196', '1253-4857-8553-5196']
const users3 = ['4857-8657-6343-0153', '0325-4857-8143-5968', '4511-4857-4788-5196']
const users4 = ['0123-8657-5196-0153', '0123-4857-8143-5968', '8553-4857-4788-5196']

ReactDOM.render( (
    <div>
        <h2 style={{fontFamily: 'Kodchasan', padding: '10px', margin: 0}}>SERVICES</h2>
        <div class="row" style={{padding: '10px'}}>
            <div class="col-sm-3"><TaskList name="Tramway TAM" tasks={users1} /></div>
            <div class="col-sm-3"><TaskList name="Piscine" tasks={users2} /></div>
            <div class="col-sm-3"><TaskList name="Bibliothèque" tasks={users3} /></div>
            <div class="col-sm-3"><TaskList name="Ludothèque" tasks={users4} /></div>
        </div>
    </div>
), container
)
