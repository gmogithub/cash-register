function MyDeco (target, a) {
    console.log(target, a);
}

export class TestDecorator {
    static newInstance () {
        return new TestDecorator();
    }

    @MyDeco
    test () {

    }

}