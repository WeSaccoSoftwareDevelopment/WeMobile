import SwiftUI
import ComposeApp

struct ContentView: View {
    @State private var showContent = false
    var body: some View {
        MainView()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
