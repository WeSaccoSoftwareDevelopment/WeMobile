//
//  MainView.swift
//  iosApp
//
//  Created by stephen chacha on 03/12/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI


struct MainView: View {
    var body: some View {
        TabView {
            HomeView()
                .tabItem {
                    Image(systemName: "house.fill")
                    Text("Home")
                }

            TransactView()
                .tabItem {
                    Image(systemName: "arrow.left.arrow.right")
                    Text("Transact")
                }

            Text("Special Action")
                .tabItem {
                    Image(systemName: "arrow.triangle.2.circlepath")
                    Text(" ")
                }

            DiscoverView()
                .tabItem {
                    Image(systemName: "square.grid.2x2.fill")
                    Text("Discover")
                }

            AccountView()
                .tabItem {
                    Image(systemName: "person.circle.fill")
                    Text("Account")
                }
        }
        .accentColor(.green) // For the selected tab's highlight color
    }
}
