export const SET_RIGHTS = 'SET_RIGHTS';


export const setRights = (rights) => {
    return {
        type: SET_RIGHTS,
        payload: rights
    };
};