//
//  TransactionButton.swift
//  iosApp
//
//  Created by stephen chacha on 23/10/2024.
//

import SwiftUI

struct TransactionButton: View {
    @Environment(\.colorScheme) var colorScheme
    let title: String
    let imageName: String
    let destination: AnyView  // The view that will be navigated to

    var body: some View {
        NavigationLink(destination: destination) {
            VStack {
                Image(systemName: imageName)
                    .font(.system(size: 40))
                    .foregroundColor(.green)

                Text(title)
                    .font(.caption)
                    .foregroundColor(.white)
                    .padding(.top, 8)
            }
            .frame(minWidth: 100, minHeight: 100)
            .background(Color.gray.opacity(0.7))
            .cornerRadius(10)
        }
    }
}

