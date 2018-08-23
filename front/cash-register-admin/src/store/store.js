import {createStore, combineReducers} from "redux";
import {rightReducer} from './reducer/rightReducer';

const rootReducer = combineReducers({
    rightReducer
});

export const store = createStore(rootReducer);