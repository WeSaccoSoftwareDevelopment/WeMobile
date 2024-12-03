//
//  HomeComponent.swift
//  iosApp
//
//  Created by stephen chacha on 24/10/2024.
//

import SwiftUI

struct HomeComponent: View {
    var imageName: String = "gamecontroller"
    var title: String = "Games"
    var subTitle: String = "Play unlimited games"
    var destination: AnyView
    
    var body: some View {
        NavigationLink(destination: destination){
            VStack(alignment: .leading) {
                Text(title)
                    .font(.subheadline)
                    .fontWeight(.semibold)
                    .foregroundStyle(.white)
                Text(subTitle)
                    .font(.caption)
                    .fontWeight(.medium)
                    .foregroundStyle(.white)
                
                Image(systemName: imageName)
                    .font(.caption)
                    .padding(6)
                    .background(Circle().fill(.white))
                    .frame(maxWidth: .infinity, alignment: .trailing)
            }
            .padding()
            .background(RoundedRectangle(cornerRadius: 10).fill(.gray))
        }
            
        
    }
    
}
