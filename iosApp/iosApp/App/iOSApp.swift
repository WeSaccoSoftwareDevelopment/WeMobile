import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    var body: some Scene {
        WindowGroup {
            ZStack {
                ComposeContentView().edgesIgnoringSafeArea([.top])
            }
        }
    }
}

