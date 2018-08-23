import React, {Component} from 'react';
import {Main} from './views/Main'
import {Provider} from "react-redux";
import './App.css';
import {BrowserRouter as Router, Route} from "react-router-dom";
import {Rights} from "./views/admin/right/Rights";
import {store} from "./store/store";

class App extends Component {
    render() {
        return (
            <Provider store={store}>
                <Router>
                    <div className="App">
                        <Route path="/admin" component={Main}></Route>
                        <Route path="/admin/rights" component={Rights}></Route>
                        <Route path="/admin/orders" component={Rights}></Route>
                    </div>
                </Router>
            </Provider>
        );
    }
}

export default App;
