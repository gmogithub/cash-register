import * as actionRight from './../actions/rightAction'

const initialState = {
    rights: []
};

export const rightReducer = (state = initialState, action) => {
    switch (action.type) {
        case actionRight.SET_RIGHTS:
            return {...state, rights: action.payload};
        default:
            return { ...state };

    }
};